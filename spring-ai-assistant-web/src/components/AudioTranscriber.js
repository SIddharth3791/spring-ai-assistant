import axios from "axios";
import { useState } from "react";

function AudioTranscriber(){

    const[file, setFile] = useState(null);
    const[transcribeTxt, setTranscribeTxt] = useState("");


    let HostURL = "http://localhost:8080/api/transcribe/audio";

    const handleFileUpload =(e) => {
        setFile(e.target.files[0]);
    }

    const uploadFile = async() => { 
        const formData = new FormData()
        formData.append("file", file);

        try{
            const response = await axios.post(HostURL, formData, {
                headers: {
                    'Content-Type': "multipart/form-data"
                }
            });
            setTranscribeTxt(response.data)
        }catch(error){
            console.log("ERROR TRANSCRIBING AUDIO FILE -"+ error);
        }
    }

    return(
        <div>
           <h2> Audio To Text Converter </h2>
           <div className="file-input">
            <input 
                type="file" 
                accept="audio"
                onChange={handleFileUpload}/>
           </div>
           <button onClick={uploadFile}>Upload and Transcribe</button>
           <div>
                <pre className="result-text">{transcribeTxt}</pre>
            </div>
        </div>
    )
}

export default AudioTranscriber;