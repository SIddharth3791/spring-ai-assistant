import react, {useState} from 'react';
import './App.css';

function App() {

  const[activeTab, setActiveTab] = useState('image-gen')

  const handleTabChange = (tab) => {
    console.log(tab);
    setActiveTab(tab)
  }

  const checkIfctive = (selectedTab) => {
    return activeTab ===selectedTab ? "active" : "inActive";
  }
  
  return (
    <div className="App">
      <button className={checkIfctive("image-gen")} 
              onClick={() => handleTabChange("image-gen")}>Image Generator
      </button>
      <button className={checkIfctive("chat")} 
              onClick={() => handleTabChange("chat")}>Chat
      </button>
      <button className={checkIfctive("recipe-gen")} 
              onClick={() => handleTabChange("recipe-gen")}>Recipe Generator
      </button>

      <div>
        {activeTab === "image-gen" && <h2>CREATE AN IMAGE FOR ME</h2>}
        {activeTab === "chat" && <h2>ASK ME ANYTHING</h2>}
        {activeTab === "recipe-gen" && <h2>SUGGEST ME FOOD RECIPE</h2>}
      </div>
    </div>
  );
}

export default App;
