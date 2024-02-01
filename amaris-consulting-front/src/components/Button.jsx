import React from 'react';

const Button = (props) => (
    <button type="button" className="btn btn-primary" onClick={props.onClickButton}>
        Search
    </button>
);

export default Button;