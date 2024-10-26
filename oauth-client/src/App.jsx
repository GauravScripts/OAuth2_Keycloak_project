import './App.css'
import {toast, Toaster} from "react-hot-toast";
import {useAuth} from "./config/authcontext.jsx";

function App() {

const {isAuthenticated} = useAuth();
console.log(isAuthenticated)
  return (
    <>
     <Toaster/>
        {isAuthenticated ? <h1>Authenticated</h1>
            : <h1>Not Authenticated</h1>}
    </>
  )
}

export default App
