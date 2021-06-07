import React from 'react';
import styled from 'styled-components';

const headerList = styled.div`
  border: 1px solid black;
  height: 300px;
  text-align: center;
`;

const Header = () => {
  return (
    <headerList>
      <ul>
        <li>메뉴1</li>
        <li>메뉴2</li>
      </ul>
    </headerList>
  );
};

export default Header;
