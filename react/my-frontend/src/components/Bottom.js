import '../App.css';
import React from 'react';
import { Button, ButtonGroup } from '@material-ui/core';
import { useDispatch } from 'react-redux';
import { decrease, increase } from '../store';

const Bottom = () => {
  const dispather = useDispatch();
  return (
    <div className="sub_container">
      <h1>Bottom</h1>
      <ButtonGroup>
        <Button variant="contained" onClick={() => dispather(increase('2222'))}>
          증가
        </Button>
        <Button variant="contained" onClick={() => dispather(decrease())}>
          감소
        </Button>
      </ButtonGroup>
    </div>
  );
};

export default Bottom;
