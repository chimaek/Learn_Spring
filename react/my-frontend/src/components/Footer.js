import React from 'react';
import styled from 'styled-components';

const footerList = styled.div`
  border: 1px solid black;
  height: 300px;
  text-align: center;
`;

const Footer = () => {
  return (
    <footerList>
      <ul>
        <li>오시는길</li>
        <li>전화번호 : 064-724-1702</li>
      </ul>
    </footerList>
  );
};

export default Footer;
