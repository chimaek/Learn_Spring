import React from 'react';
import styled from 'styled-components';

const StyledDeleteButton = styled.button`
  color: ${(props) => (props.number === 1 ? 'blue' : 'red')};
`;

const OverrideButton = styled(StyledDeleteButton)`
  background-color: green;
`;

const Home = (props) => {
  //구조분할 할당
  const { board, setBoard, number, setNumber } = props;

  return (
    <div>
      <h1>{number}</h1>
      <OverrideButton number={number} onClick={() => setNumber(number + 1)}>
        추가하기
      </OverrideButton>
      <StyledDeleteButton number={number} onClick={() => setBoard([])}>
        전체삭제
      </StyledDeleteButton>
      {board.map((n) => (
        <h3>
          제목:{n.title}내용:{n.content}
        </h3>
      ))}
    </div>
  );
};

export default Home;
