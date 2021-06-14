import React, { useEffect, useState } from 'react';
import BookItem from '../../components/BookItem';
import axios from 'axios';
const Home = () => {
  const [books, setBooks] = useState([]);

  //함수 실행시 최초한번 실행되는것 + 상태값이 변경될때 마다 실행
  useEffect(() => {
    axios
      .get('http://localhost:8080/book') //비동기 함수 첫번쨰 인자는 promise를 반환
      .then((res) => {
        setBooks(res.data);
      });
  }, []);
  // CORS는 외부 자바스크립트 요청을 막음=> 기본

  return (
    <div>
      {books.map((book) => (
        <BookItem key={book.id} book={book}></BookItem>
      ))}
    </div>
  );
};

export default Home;
