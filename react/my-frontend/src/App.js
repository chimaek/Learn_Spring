import logo from './logo.svg';
import './App.css';
import Child from './child';
import { useState } from 'react';
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
  console.log('실행됨');
  const [number, setNumber] = useState(5);

  let sample = [
    { id: 10, name: '홍길동' },
    { id: 11, name: '홍길' },
    { id: 12, name: '홍동' },
    { id: 13, name: '길동' },
  ];

  const [users, setUsers] = useState(sample);

  const download = () => {
    setUsers([...users, { id: number, name: '홍2' }]);
    setNumber(number + 1);
  };

  return (
    <div>
      <button onClick={download}>다운로드</button>
      {users.map((u) => (
        <h1>
          {u.id},{u.name}
        </h1>
      ))}
    </div>
  );
}

export default App;
