//액션

export const increase = (username) => ({
  type: 'INCREMENT',
  payload: username,
});
export const decrease = () => ({
  type: 'DECREMENT',
});

export const getUsername = (username) => ({
  type: 'INCREMENT',
  payload: username,
});

//상태값

const initstate = {
  number: 1,
  username: '호호',
};

//액션의 결과를 걸러내는 역할
const reducer = (state = initstate, action) => {
  switch (action.type) {
    case 'INCREMENT':
      return { number: state.number + 1, username: action.payload };
    case 'DECREMENT':
      return { number: state.number - 1 };
    default:
      return state;
  }
};

export default reducer;
