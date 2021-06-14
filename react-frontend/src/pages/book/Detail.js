import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Button from '@material-ui/core/Button';
import ButtonGroup from '@material-ui/core/ButtonGroup';
import DeleteIcon from '@material-ui/icons/Delete';
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
  const deleteBook = () => {
    axios.delete('http://localhost:8080/book/' + id).then((res) => {
      if (res.data === 'ok') {
        props.history.push('/');
      }
    });
  };
  return (
    <div>
      <h1>책 상세보기</h1>
      <ButtonGroup variant="contained" color="primary">
        <Button>수정</Button>{' '}
        <Button
          color="secondary"
          startIcon={<DeleteIcon />}
          onClick={deleteBook}
        >
          삭제
        </Button>
      </ButtonGroup>

      <hr />
      <h1> 책의 이름은 : {book.title}</h1>
      <h3> 저자의 이름은 : {book.author}</h3>
    </div>
  );
};

export default Detail;
