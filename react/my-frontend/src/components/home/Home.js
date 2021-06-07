import React from 'react';

const Home = (props) => {
  //구조분할 할당
  const { board, setBoard } = props;
  const { number, setNumber } = props;

  return (
    <div>
      <h1>{number}</h1>
      <button onClick={() => setNumber(number + 1)}>번호증가</button>
      <button onClick={() => setBoard([])}>전체삭제</button>
      {board.map((n) => (
        <h3>
          제목:{n.title}내용:{n.content}
        </h3>
      ))}
    </div>
  );
};

export default Home;
