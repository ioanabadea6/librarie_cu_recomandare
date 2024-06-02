import SubmitButton from "./components/SubmitButton";
import InputField from "./components/InputField";
import UserStore from "./stores/UserStore";
import React from "react";

class LoginForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            buttonDisabled: false,
        }
    }

    setInputValue(property, val) {
        val = val.trim();
        if(val.length > 12){
            return;
        }
        this.setState({
            [property]: val
        })
    }

    resetForm(){
        this.setState({
            username: '',
            password: '',
            buttonDisabled: false
        })
    }

    async doLogin(){
        if(!this.state.username){
            return;
        }
        if(!this.state.password){
            return;
        }
        this.setState({
            buttonDisabled: true
        })

        try{
            let res = await fetch('http://localhost:8080/auth/find',{
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    username: this.state.username,
                    password: this.state.password,
                })
            });
            let result = await res.json();
            if(result && result.username){
                UserStore.isLoggedIn = true;
                UserStore.username = result.username;
            }
            else if(result && result.success === false){
                this.resetForm();
                alert(result.message);
            }
        }
        catch (e){
            console.log(e);
            this.resetForm();
        }
    }

    async doSignUp(){
        if(!this.state.username || !this.state.password){
            return;
        }

        this.setState({
            buttonDisabled: true
        });

        try {
            this.props.history.push('/signuppage'); // Schimbă '/signuppage' cu ruta corectă către pagina de înscriere
        } catch (error) {
            console.log(error);
            this.resetForm();
        }
    }

    render(){
        return (
            <div className="loginForm">
                <h2>Log In</h2>
                <InputField
                    type="text"
                    placeholder="Username"
                    value={this.state.username ? this.state.username : ''}
                    onChange={(val) => this.setInputValue('username', val)}
                />
                <InputField
                    type="password"
                    placeholder="Password"
                    value={this.state.password ? this.state.password : ''}
                    onChange={(val) => this.setInputValue('password', val)}
                />
                <h2>
                    <SubmitButton
                        text="Login"
                        disabled={this.state.buttonDisabled}
                        onClick={(e) => this.doLogin()}
                    />
                </h2>
                Don't have an account?
                <SubmitButton
                    text="Sign up"
                    disabled={this.state.buttonDisabled}
                    onClick={(e) => this.doSignUp()}
                />
            </div>
        );
    }

}

export default LoginForm;
