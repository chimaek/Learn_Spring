package com.example.demo.controller;

import com.example.demo.domain.items.Book;
import com.example.demo.domain.items.Item;
import com.example.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @GetMapping("/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "items/createItemForm";

    }

    @PostMapping("/items/new")
    public String create(@Valid BookForm bookForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "items/createItemForm";
        }
        Book book = Book.createBook(bookForm.getName(), bookForm.getAuthor(), bookForm.getIsbn(), bookForm.getPrice(), bookForm.getStockQuantity());

        itemService.saveItem(book);

        return "redirect:/items";
    }
    @GetMapping("/items")
    public String getItems(Model model){
        List<Item> items = itemService.findItems();
        model.addAttribute("items",items);
        return "items/itemList";

    }
}
