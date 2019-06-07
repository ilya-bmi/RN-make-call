import { NativeModules } from "react-native";

var RNImmediatePhoneCall = {
  call: function(number) {
    NativeModules.RNImmediatePhoneCall.immediatePhoneCall(number);
  },
  doublePhoneCall: function(number, second) {
    NativeModules.RNImmediatePhoneCall.doublePhoneCall(number, second);
  }
};

export default RNImmediatePhoneCall;
