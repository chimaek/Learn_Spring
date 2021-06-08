import React, { useEffect, useState } from 'react';

import Home from '../components/home/Home';

const Homepage = () => {
  const [board, setBoard] = useState([]);
  const [number, setNumber] = useState(0);

  //빈배열이면 무조건 한번
  useEffect(() => {
    //다운로드 가정
    let datas = [
      { id: 1, title: '제목1', content: '내용1' },
      { id: 2, title: '제목2', content: '내용2' },
      { id: 3, title: '제목3', content: '내용3' },
    ];
    setBoard([...datas]);
    setNumber(1);
  }, []);
  return (
    <Home
      board={board}
      setBoard={setBoard}
      number={number}
      setNumber={setNumber}
    ></Home>
  );
};

export default Homepage;
