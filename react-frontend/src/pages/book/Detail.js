import axios from 'axios';
import React, { useEffect, useState } from 'react';

const Detail = (props) => {
  const id = props.match.params.id;
  const [book, setBook] = useState({
    id: '',
    title: '',
    author: '',
  });
  useEffect(() => {
    axios.get('http://localhost:8080/book/' + id).then((res) => {
      setBook(res.data);
    });
  }, []);

  return (
    <div>
      <h1>책 상세보기</h1>
      <hr />
      <h3>{book.author}</h3>
      <h1>{book.title}</h1>
    </div>
  );
};

export default Detail;