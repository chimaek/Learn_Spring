import logo from './logo.svg';
import './App.css';
import Child from './child';
import { useEffect, useState } from 'react';
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
  const [data, setData] = useState(0);

  const [search, setSearch] = useState(0);
  //실행시점? -> app함수가 최초 실행될 때
  useEffect(() => {
    console.log('app실행됨');
    download();
  }, [search]);

  const download = () => {
    let downloadData = 5;
    setData(downloadData);
  };

  return (
    <div>
      <h1>검색:</h1>
      <button
        onClick={() => {
          setSearch(2);
        }}
      >
        검색하기
      </button>
      <h1>데이터{data}</h1>
      <button
        onClick={() => {
          setData(data + 1);
        }}
      >
        업데이트
      </button>
    </div>
  );
}

export default App;
