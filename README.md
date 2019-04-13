# RSA - Generating Keys, Encryption, Decryption
The purpose of this project is to demonstrate the implementation of RSA algorithm, starting from generating the public and private keys, and ending with the encryption and decryption.

I should mention that RSA is a relatively slow algorithm, and because of this, it is less commonly used to directly encrypt user data. More often, RSA passes encrypted shared keys for symmetric key cryptography which in turn can perform bulk encryption-decryption operations at much higher speed.

## Demo

![](./demos/demo.gif)


## Overall Process

### Key generation
-	Choose two distinct prime numbers `p` and `q`
-	Compute `n = pq`
-	Compute `ϕ(n) = (p-1)*(q-1) `
-	Choose an integer `e` where `1 < e < ϕ(n)` and `gcd(e, ϕ(n)) = 1;` `(e & ϕ(n) are coprime)`
-	Determine `d` as `d ≡ e−1 (mod ϕ(n));` (`d` is the modular multiplicative inverse of `e modulo ϕ(n))`
-	(`e`,`n`) is released as the public key.
-	(`d`,`n`) is kept as the private key.

### Encryption
-	The sender turns `M` (the plaintext) into an integer `m` such that `0 ≤ m < n`
-	The sender computes the ciphertext `c`, using the receiver's public key `e` such as `c ≡ (m^e) (mod n)` This can be done reasonably quickly using modular exponentiation.


### Encryption
-	The receiver can retrieve `m` from `c` using their private key by computing `m ≡ (c^d) (mod n)`
-	Given `m`, the receiver can retrieve the original message `M` by reversing the method the sender used in the first place, which is not secret.

## Implementation challenges

### int value range
In Java, the type int can hold up to 32 bits, which is not sufficient at all for an RSA implementation, so we used BigInteger, can hold up to 137438953472 bits, and that huge enough. 

### RSA methods
BigInteger has some methods that helped us dramatically, specifically “isProbablePrime”, “gcd”, “modInverse” and “modPow”, their names explain what they are used for.

### Data types conversions
#### string to a bit array
byte[] bytes = mInputField.getText().getBytes(); 

#### bit array to a BigInteger
m = new BigInteger(bytes);

#### BigInteger to bit array and then to string:
String plainText = new String(m.toByteArray());2.	 		

RSA.jar

## Installing

If you just want to install and test the app, you can download the [RSA.jar](./RSA.jar) file which you can run instantly, and you might use the [ExampleValues.txt](./ExampleValues.txt) file to help you of finding large prime numbers.


## Running locally

Each IDE have different way of opening projects, and the steps get updated constantly.

So, assuming you already know how to run java programs, running this project is no different, just clone the repo and open it from the IDE of your choice


##### Clone the repository
```shell
git clone https://github.com/ialmoqren/confirm-location
```
