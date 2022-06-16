import { ReactElement } from "react";
import { StyledButton } from "./Button.styles";


type ButtonProps = 
{
    onClick: CallableFunction,
    content: string
}

function BlogButton(props:ButtonProps) :ReactElement {
    return(
        <StyledButton onClick={() => props.onClick()}>
            {props.content}
        </StyledButton>
    )
}

export default BlogButton;