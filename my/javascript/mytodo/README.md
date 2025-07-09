# 학습과정
## 등록기능(handleInputChnge) 비제어 컴포넌트 vs 제어 컴포넌트
간단하게 React상태(state)에 의해 관리 된다면 제어 컴포넌트,  
HTML의 DOM 자체만을 이용해 입력 필드의 값을 얻어내면 비제어 컴포넌트이다.

[비제어 컴포넌트 vs 제어 컴포넌트 노션 정리](https://holistic-gerbera-6ad.notion.site/22951e653cca80738fdac6b8111db7ba?source=copy_link)

**제어 컴포넌트**
```js
const handleInputChange = (e) => {
    setInputValue(e.target.value);  // 얻어낸 값을 useState를 통해 관리
}

<form onSubmit={handleOnSubmit}>
    <input
       value={inputValue}
       ...
    />
</form>
```

**비제어 컴포넌트**
```js
const inputValue = e.target.elements.todo.value;

<form onSubmit={handleOnSubmit}>
    <input
       name="todo"
       ...
    />
</form>
```

제어 컴포넌트는 사용자의 모든 입력이 React 상태를 거쳐가기 때문에, React가 폼의 모든 변경 사항을 인지하고 제어한다.  
따라서, 유효성 검사, 조건부 렌더링 등 복잡한 로직 구현에 유리하다.

## ID를 useRef vs useState 무엇으로 관리할까
- useState: ID 값이 변경될 때마다 컴포넌트가 다시 렌더링되어야 할 필요가 있을 때 사용한다.
- useRef: ID 값이 변경되어도 컴포넌트가 다시 렌더링될 필요가 없을 때 사용한다.  

## toggleTodo에는 onClick대신 onChnage를 사용해야하는 이유 

`onClick`사용시 나타나는 경고문
```
You provided a `checked` prop to a form field without an `onChange` handler. This will render a read-only field. If the field should be mutable use `defaultChecked`. Otherwise, set either `onChange` or `readOnly`.
```
`removeTodo`처럼 단순히 **클릭 되었을 때 특정 동작이 수행되는 경우** `onClick`이 사용된다.

`toggleTodo`와 같이 **입력 요소의 '값' 또는 '상태'가 변경되는 경우** `onChange`핸들러를 제공해야만 React가 다시 렌더링할 수 있게 된다. 즉, 경고문에서와 같이 onChange 핸들러가 제공되지 않을 경우 읽기 전용이되어 내부 값의 변경이 React 상태(State)에 업데이트되지 않는다.

## localStorage와 Js의 window 객체

