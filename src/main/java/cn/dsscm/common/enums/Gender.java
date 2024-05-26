package cn.dsscm.common.enums;

public enum Gender {
   M("男"),
   F("女");
   
   private String description;
   
   Gender(String description) {
       this.description = description;
   }
   
   public String getDescription() {
       return description;
   }
   
   public static Gender fromDescription(String description) {
       for (Gender gender : Gender.values()) {
           if (gender.getDescription().equals(description)) {
               return gender;
           }
       }
       throw new IllegalArgumentException("Invalid gender description: " + description);
   }
}

