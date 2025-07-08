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

  const toggleTodo = (id) => {
    const updated = todos.map(todo =>
      todo.id === id ? { ...todo, completed: !todo.completed } : todo
    );
    setTodos(updated);
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
      <TodoList todos={todos} removeTodo={removeTodo} toggleTodo={toggleTodo} />
    </>
  )
}

function TodoList({ todos, removeTodo, toggleTodo }) {
  return (
    <ul>
      {todos.map((todo) => (
        <li key={todo.id}>
          <input type="checkbox" checked={todo.completed} onClick={() => toggleTodo(todo.id)}></input>
          {todo.value}
          <button onClick={() => removeTodo(todo.id)}> X </button>
        </li>
      ))}
    </ul>
  );
}

export default App;