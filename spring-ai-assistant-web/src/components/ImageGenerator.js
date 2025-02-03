import React, { useState } from "react";

function ImageGenerator(){

    const[imgPrompt, setImgPrompt] = useState('');
    const[imageUrls, setImageUrls ] = useState([]);

    let HostURL = "http://localhost:8080/api/createImg?imageIdea=";

    const generateImage = async() => {
        try{
            const response  = await fetch(HostURL+`${imgPrompt}`)
            const urls = await response.json();
            setImageUrls(urls);
        }catch(error){
            console.log("ERROR WHILE FETCH IMG URLS {}", error)
        }
    }

    return (
        <div className="tab-content">
                <h2>Generate Custom Image</h2>
                <input
                    type="text"
                    value={imgPrompt}
                    onChange={(text) => setImgPrompt(text.target.value)}
                    placeholder="Enter Prompt For Image"/>
                <button onClick={generateImage}>Generate Images</button>

                <div className="image-grid">
                    {imageUrls.map((url, index) => (
                        <img key={index} src={url} alt={`generated ${index}`} />
                    ))}

                    {[...Array(4-imageUrls.length)].map((_, index) => (
                        <div key={index + imageUrls.length} className="empty-image-slot"></div>
                    ))}
                </div>
        </div>
    );
}

export default ImageGenerator;