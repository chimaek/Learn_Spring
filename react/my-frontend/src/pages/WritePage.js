import { Button, TextField } from '@material-ui/core';
import React from 'react';

const handleWrite = () => {
  let post = { id: 6, title: '인풋값' };
};

const WritePage = (props) => {
  const { setPosts } = props;
  return (
    <div>
      <h1>글쓰기 페이지</h1>
      <hr></hr>

      <form>
        <TextField
          id="outlined-basic"
          label="제목"
          variant="outlined"
        ></TextField>
        <Button
          color="primary"
          setPosts={setPosts}
          variant="contained"
          onClick={handleWrite}
        >
          글쓰기
        </Button>
      </form>
    </div>
  );
};

export default WritePage;
