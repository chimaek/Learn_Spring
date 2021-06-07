import logo from './logo.svg';
import './App.css';
import Child from './child';
import { createRef, useEffect, useMemo, useRef, useState } from 'react';
import Sub from './sub';
import styled from 'styled-components';
import Header from './components/Header';
import Footer from './components/Footer';
import LoginPage from './pages/LoginPage';
import Homepage from './pages/Homepage';

// 1.실행방식
// 변수선언은 var가 아닌 let또는 const로만 할것!
// if 사용불가능 -> 삼항연산자 사용
// 조건부 렌더링(조건&& 값) 값이 있으면 보여줌
// css디자인 방법
// (1) 내부에 적는 방법 => 추천 안함
// (2) 외부파일 적는 방법
// (3) 라이브러리 사용(부트스트랩)

const Title = styled.h1`
  font-size: 1.5em;
  text-align: center;
  color: palevioletred;
`;

function App() {
  return (
    <div>
      <LoginPage></LoginPage>
      <Homepage></Homepage>
    </div>
  );
}

export default App;
