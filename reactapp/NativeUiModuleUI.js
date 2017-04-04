import React from 'react';
import { View, Text, StyleSheet, Button } from 'react-native';

import Callback from './Callback';

var CustomUI = require('./CustomUIFromAndroid');

export default class NativeModuleUI extends React.Component {
  render() {
    return ( 
        <CustomUI>
        </CustomUI>
      );
  }
}

var styles = StyleSheet.create({
   mainContainer:{
        flex : 1,
        backgroundColor:'#81c04d',
        flexDirection: 'column',
        justifyContent: 'space-around',
        alignItems: 'center',
    }
});

module.exports = NativeModuleUI;