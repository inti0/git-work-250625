import { useState, useRef } from "react"

function App() {

  const initialState = [
    {
      id: 1,
      value: '할일 1',
      completed: true
    },
    {
      id: 2,
      value: '할일 2',
      completed: false
    },
    {
      id: 3,
      value: '할일 3',
      completed: false
    }
  ]

  const idRecorder = useRef(4);

  const [todos, setTodos] = useState(initialState);
  const [inputValue, setInputValue] = useState('');

  const handleInputChange = (e) => {
    setInputValue(e.target.value);
  }

  //form TODO 등록
  const handleOnSubmit = (e) => {
    e.preventDefault();
    const formValue = inputValue;
    const newTodos = [{ id: idRecorder.current++, value: formValue, completed: false }, ...todos];
    setTodos(newTodos);
    setInputValue('');
  }

  const removeTodo = (id) => {
    const filtered = todos.filter(todo => todo.id !== id);
    setTodos(filtered);    
  }

  return (
    <>
      <form onSubmit={handleOnSubmit}>
        <input
          type="text"
          value={inputValue}
          onChange={handleInputChange}
          placeholder="새로운 할 일을 입력하세요" />
        <button>등록</button>
      </form>
      <TodoList todos={todos} removeTodo={removeTodo}/>
    </>
  )
}

function TodoList({ todos, removeTodo }) {
  return (
    <ul>
      {todos.map((todo) => (
        <li key={todo.id}>
          {todo.value}
          <button onClick={() => removeTodo(todo.id)} type="checkbox" checked="false"> X </button>
        </li>
      ))}
    </ul>
  );
}

export default App;