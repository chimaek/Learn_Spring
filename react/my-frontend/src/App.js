import logo from './logo.svg';
import './App.css';
import Child from './child';
import { useEffect, useMemo, useState } from 'react';
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
  const [list, setList] = useState([1, 2, 3, 4]);
  const [sample, setSample] = useState('합계');

  const add = () => {
    let sum = 0;
    list.forEach((i) => (sum = sum + i));
    console.log(sum);
    return sum;
  };

  const addResult = useMemo(() => add(), [list]);

  return (
    <div>
      <button
        onClick={() => {
          setSample('안녕');
        }}
      >
        문자변경
      </button>
      <button
        onClick={() => {
          setList([...list, 10]);
        }}
      >
        추가하기
      </button>
      <div>
        {list.map((n) => (
          <h1>{n}</h1>
        ))}
      </div>
      <div>
        {sample}:{addResult}
      </div>
    </div>
  );
}

export default App;
