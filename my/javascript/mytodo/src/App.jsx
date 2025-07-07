import { useState } from "react"

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

  const [todos, setTodos] = useState(initialState);

  return (
    <>
      <form>
        <input type="text" />
        <button>등록</button>
      </form>
      <TodoList todos={todos} />
    </>
  )
}

function TodoList({ todos }) {
  return (
    <ul>
      {todos.map((todo) => {
        <li key={todo.id}>
          {todo.value}
        </li>
      })}
    </ul>
  );
}

export default App;