import React, { useState } from 'react';
import './App.css';

import MonacoEditor from '@monaco-editor/react';
import {compileAndRunCode} from './operations/runOperation';

function App() {
  const [codeArea, setCodeToExecute] = useState(
    `// Write your Java code here
    public class Main {
      public static void main(String[] args) {
        System.out.println("Hello, World!");
      }
    }`
);

  return (
    <>
      <div className="mainPage">
        <div>
        <MonacoEditor
          height="90vh"
          width="50vw"
          language="java"
          theme="vs-dark"
          value={codeArea}
          onChange={(e)=>setCodeToExecute(e)}
        />
          <button onClick={()=> compileAndRunCode()}>RUN</button>
        </div>

        <div className='compilerArea'>
          <div>{codeArea}</div>
        </div>


      </div>

    </>
  );
}

export default App;
