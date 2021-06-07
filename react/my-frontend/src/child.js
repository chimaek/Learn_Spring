function Child() {
  let a = 10;
  return (
    <h1 className="box-style">
      해딩태그{a === 10 ? '10입니다.' : '10이 아닙니다.'}
    </h1>
  );
}

export default Child;
