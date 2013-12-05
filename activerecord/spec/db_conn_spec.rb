require 'spec_helper'
require 'rubygems'
require 'active_record'
require 'require_all'
require 'yaml'
require 'logger'

require_rel '../app/models'

describe 'DB Connection' do

   before do
     db_config = YAML::load(File.open('db/database.yml'))

     ActiveRecord::Base::establish_connection(db_config['development'])
     ActiveRecord::Base.logger = Logger.new(STDOUT)
   end

  it 'should connect to DB' do
    TCategory.count.should eq(0)
  end

end