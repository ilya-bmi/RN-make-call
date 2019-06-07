import { NativeModules } from "react-native";

var RNImmediatePhoneCall = {
  call: function(number) {
    NativeModules.RNImmediatePhoneCall.immediatePhoneCall(number);
  },
  doublePhoneCall: function(number, second, delay) {
    NativeModules.RNImmediatePhoneCall.doublePhoneCall(number, second, delay);
  }
};

export default RNImmediatePhoneCall;
