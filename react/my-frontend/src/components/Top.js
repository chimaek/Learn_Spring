import '../App.css';
import React from 'react';

const Top = (props) => {
  const { number } = props;
  return (
    <div className="sub_container">
      <h1>Top</h1>
      번호 : {number}
    </div>
  );
};

export default Top;
