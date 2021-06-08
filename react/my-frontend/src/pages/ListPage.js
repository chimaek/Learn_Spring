import { Box, Button, TextField } from '@material-ui/core';
import React, { useState } from 'react';
import styled from 'styled-components';

const StyledItemBoxDiv = styled.div`
  display: flex;
  justify-content: space-between;
  border: 1px solid black;
  padding: 10px;
  height: 100px;
  margin: 20px;
  align-items: center;
`;

const ListPage = () => {
  const [post, setPost] = useState({ id: 5, title: '', content: '' });

  const [posts, setPosts] = useState([
    { id: 1, title: '제목1', content: '내용1' },
    { id: 2, title: '제목2', content: '내용2' },
    { id: 3, title: '제목3', content: '내용3' },
    { id: 4, title: '제목4', content: '내용4' },
    { id: 5, title: '제목5', content: '내용5' },
  ]);

  const handleWrite = (e) => {
    e.preventDefault(); // form태그가 하려는 액션을 중지 시켜야 함.
    console.log(1, post.id);

    console.log(2, post.id);
    setPosts([...posts, { ...post, id: post.id + 1 }]);
    console.log(3, post.id);
    setPost({ ...post, id: post.id + 1 });
  };

  const handleForm = (e) => {
    // computed property names 문법 (키값 동적할당)
    setPost({
      ...post,
      [e.target.name]: e.target.value,
    });
  };

  const handelDelete = (id) => {
    setPosts(posts.filter((post) => post.id !== id));
  };

  return (
    <div>
      <h1>글목록 페이지</h1>
      <form onSubmit={handleWrite}>
        <input
          type="text"
          placeholder="제목을 입력하세요"
          value={post.title}
          onChange={handleForm}
          name="title"
        ></input>
        <input
          type="text"
          placeholder="내용을 입력하세요"
          value={post.content}
          onChange={handleForm}
          name="content"
        ></input>
        <Button type="submit" color="primary" variant="contained">
          글쓰기
        </Button>
      </form>
      <hr />
      {posts.map((post) => (
        <StyledItemBoxDiv>
          <div>번호 : {post.id}</div>
          <div>제목 : {post.title}</div>
          <div>내용 : {post.content}</div>
          <Button variant="contained" onClick={() => handelDelete(post.id)}>
            삭제
          </Button>
        </StyledItemBoxDiv>
      ))}
    </div>
  );
};

export default ListPage;
