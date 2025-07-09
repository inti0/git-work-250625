import TodoSubmitForm from "./component/TodoSubmitForm";
import TodoList from "./component/TodoList";
import { useTodos } from "./hooks/useTodos";

function App() {
  const {todos, removeTodo, toggleTodo, addTodo} = useTodos();
  return (
    <>
      <TodoSubmitForm addTodo={addTodo} />
      <TodoList todos={todos} removeTodo={removeTodo} toggleTodo={toggleTodo} />
    </>
  )
}

export default App;