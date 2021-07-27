package com.example.demo.service;

import com.example.demo.domain.Address;
import com.example.demo.domain.Member;
import com.example.demo.domain.Order;
import com.example.demo.domain.OrderStatus;
import com.example.demo.domain.items.Book;
import com.example.demo.domain.items.Item;
import com.example.demo.domain.items.NotEnoughStockException;
import com.example.demo.repository.OrderRepository;
import org.aspectj.weaver.ast.Not;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest
class OrderServiceTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;


    @Test
    public void 상품주문() throws Exception {
        //given
        Member member = createMember("dmdmdmmd", new Address("서울", "가로수길", "12345"));
        Item itemBook = createBook("JPA", 10000, 100);

        int orderCount = 5;
        //when
        Long orderId = orderService.order(member.getId(), itemBook.getId(), orderCount);

        //then
        Order orderRepositoryOne = orderRepository.findOne(orderId);

        assertThat(orderRepositoryOne.getStatus()).as("주문 상태를 확인해 주세요 현재값 %s", orderRepositoryOne.getStatus().toString()).isEqualTo(OrderStatus.ORDER);
        assertThat(orderRepositoryOne.getOrderItemList().size()).as("현재 상품 종류 수 %d", orderRepositoryOne.getOrderItemList().size()).isEqualTo(1);
        assertThat(orderRepositoryOne.getTotalPrice()).as("주문 가격 : %d", orderRepositoryOne.getTotalPrice()).isEqualTo(10000 * orderCount);
        assertThat(itemBook.getStockQuantity()).isEqualTo(95);
//        assertThat(orderRepositoryOne.getStatus()).isEqualTo(OrderStatus.ORDER);


    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }

    private Member createMember(String name, Address address) {
        Member member = new Member();
        member.setName(name);
        member.setAddress(address);
        em.persist(member);
        return member;
    }

    @Test
    public void 상품주문_초과() throws Exception {

        Member member = createMember("dmdmdmmd", new Address("서울", "가로수길", "12345"));
        Item itemBook = createBook("JPA", 10000, 100);

        int orderCount = 10001;


        assertThrows(NotEnoughStockException.class, () -> {
            orderService.order(member.getId(), itemBook.getId(), orderCount);
        });

    }

    @Test
    public void 주문취소() throws Exception {
        //given
        Member member = createMember("dmdmdmmd", new Address("서울", "가로수길", "12345"));
        Book item =  createBook("s",10000,10);

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(),item.getId(),orderCount);

        //when
        orderService.cancelOrder(orderId);

        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertThat(getOrder.getStatus()).isEqualTo(OrderStatus.CANCEL);
        assertThat(item.getStockQuantity()).isEqualTo(10);

    }

}