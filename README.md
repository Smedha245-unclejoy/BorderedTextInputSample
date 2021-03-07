# BorderedTextInputSample

A handy Custom TextInputLayout view with configurable right drawable and left drawable cta , and error view. 
Often times we receive a common Text input view design from UI team and it becomes real pain when you have to add a 
button inside the Text Input layout and do something on click of that button or show error for all these input fields in a certain way . 

To ease the process for a similar requirement , I used this custom view to make it easier for development . 

It is just an idea you can study the code and customize it as per your use case . 

To use the view in layout : 

<com.medha.borderedtextinputsample.BorderedEditTextWithHeader
        android:id="@+id/orderDate"
        android:layout_width="0dp"
        android:layout_height="80dp"
        android:layout_marginTop="@dimen/margin_medium"
        app:drawableRightCta="@drawable/calendar_purple"
        app:etHint="Date"
        app:layout_constraintEnd_toEndOf="@id/endGuide"
        app:layout_constraintStart_toStartOf="@id/startGuide"
        app:layout_constraintTop_toTopOf="@id/topGuide" />
        
        
 Support for xml attributes of custom and inbuilt type is provided in attrs.xml 
 
 <declare-styleable name="BorderedEditTextWithHeader">
        <attr name="etHint" format="string" />
        <attr name="etText" format="string"/>
        <attr name="android:inputType" />
        <attr name="android:longClickable"/>
        <attr name="android:enabled" format="boolean" />
        <attr name="android:imeOptions"/>
        <attr name="android:maxLength"/>
        <attr name="drawableRightCta" format="reference"/>
        <attr name="drawableLeftCta" format="reference"/>
        <attr name="ctaText" format="string"/>
        <attr name="ctaTextColor" format="color"/>

    </declare-styleable>
    
    You can change icon and text of Text INput Edit text dynamically like this : 
    
    binding.contentLayout.phoneNumberEt.etBordered.addTextChangedListener(object:
            TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                Log.e("after",p0.toString()?:"")
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.e("before",p0.toString()?:"")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if((p0?.length?:0)==10){
                    Log.e("on",p0.toString()?:"")
                    binding.contentLayout.phoneNumberEt.setCtaTextColor(R.color.accent_green)
                    binding.contentLayout.phoneNumberEt.setDrawableTextAndCta("Verified",null,
                        ContextCompat.getDrawable(this@MainActivity,R.drawable.phone_verified))
                }else{
                    binding.contentLayout.phoneNumberEt.setError("PLease enter a valid number")
                    val rotated = ContextCompat.getDrawable(this@MainActivity, R.drawable.purple_right_arrow)
                    binding.contentLayout.phoneNumberEt.setCtaTextColor(R.color.colorAccent)
                    binding.contentLayout.phoneNumberEt.setDrawableTextAndCta("Verify Your Number", null, rotated)
                }
            }
        })
    }
    
    //To set error : 
    binding.contentLayout.phoneNumberEt.setError("PLease enter a valid number")
    
    //Handle Right Cta click : 
    
    binding.contentLayout.phoneNumberEt.rightCtaTv.setOnClickListener {
            // implement as per your convenience
        }
        
        
      [imagetest1!](https://github.com/Smedha245-unclejoy/BorderedTextInputSample/blob/master/photo_2021-03-07_19-48-43%20(2).jpg)  
      
      [imagetest2!](https://github.com/Smedha245-unclejoy/BorderedTextInputSample/blob/master/photo_2021-03-07_19-48-43%20(3).jpg)  
      
      [imagetest3!](https://github.com/Smedha245-unclejoy/BorderedTextInputSample/blob/master/photo_2021-03-07_19-48-43%20(4).jpg)  
      
      [imagetest4!](https://github.com/Smedha245-unclejoy/BorderedTextInputSample/blob/master/photo_2021-03-07_19-48-43.jpg)  
