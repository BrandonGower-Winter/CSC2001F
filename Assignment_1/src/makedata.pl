# Test data generator for telephone directory
# Hussein Suleman
# 23 March 2017

use Data::Faker;

my $faker = Data::Faker->new();

for (my $i=0; $i<10000; $i++ )
{
   print $faker->street_address.", ".$faker->city."|".$faker->phone_number."|".$faker->last_name." ".$faker->first_name."\n";
}
