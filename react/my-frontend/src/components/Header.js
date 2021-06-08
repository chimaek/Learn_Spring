import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import Button from '@material-ui/core/Button';
import {
  ButtonBase,
  ButtonGroup,
  IconButton,
  StepButton,
  TabScrollButton,
} from '@material-ui/core';
const StyledHeaderButtonDiv = styled.div`
  border: 1px solid black;
  height: 300px;
  background-color: ${(props) => props.backgroundColor};
`;

const StyledHeaderLink = styled(Link)`
  color: red;
`;

const Header = () => {
  return (
    <ButtonGroup backgroundColor="green">
      <ul>
        <li>
          <StyledHeaderLink to="/">홈</StyledHeaderLink>
        </li>
        <li>
          <StyledHeaderLink to="/login/10">로그인</StyledHeaderLink>
        </li>
      </ul>
    </ButtonGroup>
  );
};

export default Header;
