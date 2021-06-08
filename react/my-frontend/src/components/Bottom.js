import '../App.css';
import React from 'react';
import { Button } from '@material-ui/core';

const Bottom = (props) => {
  const { addNumber } = props;

  return (
    <div className="sub_container">
      <h1>Bottom</h1>
      <Button onClick={() => addNumber()} variant="contained">
        증가
      </Button>
    </div>
  );
};

export default Bottom;
