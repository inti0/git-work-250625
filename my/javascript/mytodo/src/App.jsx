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

  const handleOnSubmit = (e) => {
    e.preventDefault();
    const formValue = e.target.elements.todo.value;
    const newTodos = [{ id: idRecorder.current++, value: formValue, completed: false}, ...todos];
    setTodos(newTodos);
  }

  return (
    <>
      <form onSubmit={handleOnSubmit}>
        <input type="text" name="todo"/>
        <button>등록</button>
      </form>
      <TodoList todos={todos} />
    </>
  )
}

function TodoList({ todos }) {
  return (
    <ul>
      {todos.map((todo) => (
        <li key={todo.id}>
          {todo.value}
        </li>
      ))}
    </ul>
  );
}

export default App;