import logo from './logo.svg';
import './App.css';
import Child from './child';
import { createRef, useEffect, useMemo, useRef, useState } from 'react';
import Sub from './sub';
// 1.실행방식
// 변수선언은 var가 아닌 let또는 const로만 할것!
// if 사용불가능 -> 삼항연산자 사용
// 조건부 렌더링(조건&& 값) 값이 있으면 보여줌
// css디자인 방법
// (1) 내부에 적는 방법 => 추천 안함
// (2) 외부파일 적는 방법
// (3) 라이브러리 사용(부트스트랩)

function App() {
  const myRef = useRef(null);
  const [list, setList] = useState([
    { id: 1, name: '잇' },
    { id: 2, name: '잇' },
  ]);
  const myRefs = Array.from({ length: list.length }).map(() => createRef());
  return (
    <div>
      <button
        onClick={() => {
          console.log(myRef);
          myRef.current.style.backgroundColor = 'red';
          myRefs[0].current.style.backgroundColor = 'blue';
        }}
      >
        변경하기
      </button>
      <div ref={myRef}>박스</div>
      {list.map((user, index) => (
        <h1 ref={myRefs[index]}>{user.name}</h1>
      ))}
    </div>
  );
}

export default App;
