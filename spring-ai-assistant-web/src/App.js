import react, {useState} from 'react';
import './App.css';
import ImageGenerator from './components/ImageGenerator';
import RecipeGenerator from './components/RecipeGenerator';
import ChatGenerator from './components/ChatGenerator';

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
        {activeTab === "image-gen" && <ImageGenerator />}
        {activeTab === "chat" && <ChatGenerator />}
        {activeTab === "recipe-gen" && <RecipeGenerator />}
      </div>
    </div>
  );
}

export default App;
