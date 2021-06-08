import logo from './logo.svg';
import './App.css';
import { createRef, useEffect, useMemo, useRef, useState } from 'react';
import styled from 'styled-components';

import LoginPage from './pages/LoginPage';
import Homepage from './pages/Homepage';
import Header from './components/Header';
import Footer from './components/Footer';
import { Route } from 'react-router';
import Navigation from './components/Navigation';
import ListPage from './pages/ListPage';
import WritePage from './pages/WritePage';
import Top from './components/Top';
import Bottom from './components/Bottom';

// 1.실행방식
// 변수선언은 var가 아닌 let또는 const로만 할것!
// if 사용불가능 -> 삼항연산자 사용
// 조건부 렌더링(조건&& 값) 값이 있으면 보여줌
// css디자인 방법
// (1) 내부에 적는 방법 => 추천 안함
// (2) 외부파일 적는 방법
// (3) 라이브러리 사용(부트스트랩)

function App() {
  const [number, setNumber] = useState(1);

  const addNumber = () => {
    setNumber(number + 1);
  };

  return (
    <div className="container">
      <h1>최상단 화면</h1>
      <Top number={number} />
      <Bottom addNumber={addNumber} />
    </div>
  );
}

export default App;
