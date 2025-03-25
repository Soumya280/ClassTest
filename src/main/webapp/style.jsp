<style>

body {
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #004d40, #009688);
    color: white;
    text-align: center;
    height: 100vh;
    width: 100vw;
    margin: 0;
    padding: 0;
}

nav {
    background: linear-gradient(135deg, #006d5b, #00a676);
    padding: 15px;
    text-align: center;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

nav ul {
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    justify-content: center;
    gap: 20px;
}

nav ul li {
    display: inline;
}

nav ul li a {
    color: #ffdd33;
    text-decoration: none;
    font-size: 18px;
    transition: 0.3s;
}

nav ul li a:hover {
    color: white;
    text-decoration: underline;
}

.container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 90vh;
}

form {
    background: rgba(255, 221, 51, 0.9);
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 300px;
}

input[type="text"], input[type="submit"] {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: none;
    border-radius: 5px;
}

input[type="text"] {
    background: #ffffff;
    color: #333;
    font-size: 16px;
}

input[type="submit"] {
    background: #006d5b;
    color: white;
    font-weight: bold;
    cursor: pointer;
    transition: 0.3s;
}

input[type="submit"]:hover {
    background: #004d40;
}

table {
    width: 80%;
    margin: 20px auto;
    border-collapse: collapse;
    background: rgba(255, 221, 51, 0.9);
    color: #333;
    border-radius: 10px;
    overflow: hidden;
}

table th, table td {
    padding: 10px;
    border: 1px solid #333;
}

table th {
    background: #006d5b;
    color: white;
}

table tr:nth-child(even) {
    background: #f2f2f2;
}

button {
    background: #006d5b;
    color: white;
    padding: 10px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: 0.3s;
}

button:hover {
    background: #004d40;
}

</style>