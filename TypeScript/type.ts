import React, { useState } from 'react';

function Main() {
    const [name, setName] = useState('')
    const [password, setPassword] = useState('')
    const [error, setError] = useState(false)
    const [submit, setSubmit] = useState(false)
    function reload(){
        window.location.reload(false)
    }
    const handlesubmit = (e) => {
        e.preventDefault()
        if (name.length == 0) {
            setError(true)
        }
        else if (password.length == 0) {
            setError(true)
        }
        else {
            setSubmit(true)
        }
    }
    const success = () => {
        if (submit) {
            return (
                <div>
                    <h1>Success fully registered {name}</h1>
                </div>
            )
        }
    }
    return (
        <div>
            {success()}
            <form onSubmit={handlesubmit}>
                <div><input type="text" placeholder='Enter Name' onChange={e => setName(e.target.value)} /></div>
                {error && name.length == 0 ?
                    <label >Name cannot be Empty</label> : ""}
                <div><input type="text" placeholder='Enter password' onChange={e => setPassword(e.target.value)} /></div>
                {error && password.length <3 ?
                    <label >password should cantain more than 3 charecters</label> : ""}
                    <button type="submit">submit</button>
                    <button type="reset">Reset</button>
                    <button onClick={()=>reload()}>Reload</button>


            </form>
        </div>
    )
}
export default Main;







app.js//


import Main from './Main';
import './App.css';

function App() {
  return (
    <div className="App">
      <Main/>
    </div>
  );
}

export default App;
