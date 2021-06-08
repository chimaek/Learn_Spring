import React from 'react';

import Login from '../components/Login';

const LoginPage = (props) => {
  const { history } = props;
  return (
    <div>
      <button onClick={() => history.goBack(1)}>뒤로가기</button>
      <Login></Login>
    </div>
  );
};

export default LoginPage;
