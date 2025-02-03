import react, { useState } from "react";

function ChatGenerator(){

    const [promptQuestion, setPromptQuestion] = useState("");
    const [aiResponse, setAiResponse] = useState("");

    let HostURL = "http://localhost:8080/api/ask/question?prompt=";

    const askAI = async () => {
        try{
            const response = await fetch(HostURL +`${promptQuestion}`)
            const responseText = await response.text();
            console.log("RESPONSE FORM AI: "+ responseText)
            setAiResponse(responseText);
        }catch(error){
            console.log("ERROR WHILE FETCH ANSWERS: "+ error)
        }
    };
    return (
        <div>
                <h2>No Question is Wrong Question</h2>
                <input
                    type="text"
                    value={promptQuestion}
                    placeholder="Ask Me Anything......."
                    onChange={(input) => setPromptQuestion(input.target.value)}
                />
                <button onClick={ askAI }>Ask AI Assistant</button>
                <div className="output">
                    <p>{aiResponse}</p>
                    
                </div>
        </div>
    )
}

export default ChatGenerator;