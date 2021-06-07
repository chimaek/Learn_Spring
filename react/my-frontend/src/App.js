rimport logo from './logo.svg';
import './App.css';
import Child from './child';
// 1.실행방식
// 변수선언은 var가 아닌 let또는 const로만 할것!
// if 사용불가능 -> 삼항연산자 사용
// 조건부 렌더링(조건&& 값) 값이 있으면 보여줌
// css디자인 방법
// (1) 내부에 적는 방법 => 추천 안함
// (2) 외부파일 적는 방법
// (3) 라이브러리 사용(부트스트랩)

let a = 20;
function App() {
  let c;
  console.log(c);
  let b = 20;

  function hello() {
    let c = 20;
  }
  //(1)
  const mystyle = {
    color: 'red',
  };

  return (
    <div>
      <div className="box-style">
        안녕111{a + b}
        {b === 20 && '20입니다.'}
      </div>
      <Child />
      <hr></hr>
    </div>
  );
}

export default App;
