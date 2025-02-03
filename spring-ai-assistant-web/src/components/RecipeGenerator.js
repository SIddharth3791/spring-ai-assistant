import React, { useState } from "react";

function RecipeGenerator(){

    const [ingredients, setIngredients] = useState("");
    const [cusine, setCusine] = useState("");
    const [dietryRes , setDietryRes] = useState("")
    const [recipe, setRecipe] = useState("")

    let HostURL = "http://localhost:8080/api/create/recipe";

    const generateRecipe = async()=>{
        try{
        const userRequest = {
            ingridients: ingredients,
            cuisine: cusine,
            dietaryRestriction: dietryRes
        }

        const response = await fetch(HostURL, {
            method: "POST",
            headers:{
                "Content-Type": "application/json",
            },
            body: JSON.stringify(userRequest)
        })

        const recipeText = await response.text();
        setRecipe(recipeText);
        }catch(error){
            console.log("ERROR WHILE FETCH RECIPE {}", error)
        }
    }


    return(
        <div>
                 <h2>Your Personal Chef</h2>
                 <input
                    type="text"
                    value={ingredients}
                    onChange={(items) => setIngredients(items.target.value)}
                    placeholder="Enter Ingredients Of Your Choice... (comma seperated)"
                 />

                <input
                    type="text"
                    value={cusine}
                    onChange={(typeOfFood) => setCusine(typeOfFood.target.value)}
                    placeholder="Enter Cusine Of Your Choice.."
                 />

                <input
                    type="text"
                    value={dietryRes}
                    onChange={(restriction) => setDietryRes(restriction.target.value)}
                    placeholder="Enter Any Dietry Restriction... (comma seperated)"
                 />
                 <button onClick={generateRecipe}> Generate Recipe</button>

                 <div>
                    <pre className="result-text">{recipe}</pre>
                 </div>


        </div>
    )
}

export default RecipeGenerator;