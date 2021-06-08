import React from 'react';
import styled from 'styled-components';

const StyledHeaderButtonDiv = styled.div`
  border: 1px solid black;
  height: 300px;
  background-color: ${(props) => props.backgroundColor};
`;

const Header = () => {
  return (
    <StyledHeaderButtonDiv backgroundColor="blue">
      <ul>
        <li>메뉴1</li>
        <li>메뉴2</li>
      </ul>
    </StyledHeaderButtonDiv>
  );
};

export default Header;
